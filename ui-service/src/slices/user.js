import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { setMessage } from "./message";
import UserService from "../services/user.service";

const initialState = {
  loading: false,
  usersApp: [],
  user: {
    username: "",
    last_login: "",
    roles: [],
    accountStatus: true,
  },
};
export const getAllUsers = createAsyncThunk(
  "user/getAllUsers",
  async (thunkAPI) => {
    try {
      const data = await UserService.getAllUsers();
      return { users: data };
    } catch (error) {
      const message =
        (error.response &&
          error.response.data &&
          error.response.data.message) ||
        error.message ||
        error.toString();
      thunkAPI.dispatch(setMessage(message));
      return thunkAPI.rejectWithValue();
    }
  }
);
export const getUserByUsername = createAsyncThunk(
  "user/getUserByUsername",
  async (username, thunkAPI) => {
    try {
      const data = await UserService.getUserByUsername(username);
      return { user: data };
    } catch (error) {
      const message =
        (error.response &&
          error.response.data &&
          error.response.data.message) ||
        error.message ||
        error.toString();
      thunkAPI.dispatch(setMessage(message));
      return thunkAPI.rejectWithValue();
    }
  }
);

export const register = createAsyncThunk(
  "user/register",
  async ({ username, password, rolesIds }, thunkAPI) => {
    try {
      const response = await UserService.register(username, password, rolesIds);
      thunkAPI.dispatch(setMessage(response.data.message));
      return response.data;
    } catch (error) {
      const message =
        (error.response &&
          error.response.data &&
          error.response.data.message) ||
        error.message ||
        error.toString();
      thunkAPI.dispatch(setMessage(message));
      return thunkAPI.rejectWithValue();
    }
  }
);

const userSlice = createSlice({
  name: "user",
  initialState,
  extraReducers: {
    [register.pending]: (state, action) => {
      state.loading = true;
    },
    [register.fulfilled]: (state, action) => {
      state.loading = false;
    },
    [register.rejected]: (state, action) => {
      state.loading = false;
    },
    [getAllUsers.pending]: (state, action) => {
      state.loading = true;
    },
    [getAllUsers.fulfilled]: (state, action) => {
      state.loading = false;
      state.usersApp = action.payload.users;
    },
    [getAllUsers.rejected]: (state, action) => {
      state.loading = false;
    },
    [getUserByUsername.pending]: (state, action) => {
      state.loading = true;
    },
    [getUserByUsername.fulfilled]: (state, action) => {
      state.loading = false;
      state.user = action.payload.user;
    },
  },
});

const { reducer } = userSlice;
export default reducer;
