import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { setMessage } from "./message";
import UserService from "../services/user.service";

const initialState = {
  loading: false,
  usersApp: [],
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

const userSlice = createSlice({
  name: "user",
  initialState,
  extraReducers: {
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
