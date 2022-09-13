import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { setMessage } from "./message";
import UserService from "../services/user.service";

const user = JSON.parse(localStorage.getItem("user"));

// const initialState = {
//   loading: false,
//   usersApp: [],
// };
const initialState = user
  ? { isLoggedIn: true, user, loading: false, usersApp: [] }
  : { isLoggedIn: false, user: null, loading: false, usersApp: [] };
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

export const register = createAsyncThunk(
  "user/register",
  async ({ username, password }, thunkAPI) => {
    try {
      console.log(username, password);
      const response = await UserService.register(username, password);
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
    [register.fulfilled]: (state, action) => {
      state.isLoggedIn = false;
    },
    [register.rejected]: (state, action) => {
      state.isLoggedIn = false;
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
  },
});

const { reducer } = userSlice;
export default reducer;
