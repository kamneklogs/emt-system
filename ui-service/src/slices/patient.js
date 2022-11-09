import { createSlice, createAsyncThunk } from "@reduxjs/toolkit";
import { setMessage } from "./message";
import PatientService from "../services/patient.service";

const initialState = {
  loading: false,
  patient: {
    id: "",
    personalInformation: {
      id: "",
      firstName: "",
      lastName: "",
      email: "",
      birthDate: "",
      genderId: "",
      civilStatusId: "",
      phoneNumber: "",
      address: "",
    },
    diseaseHistorial: {
      firstDisease: {
        code: "",
        name: "",
      },
      secondDisease: {
        code: "",
        name: "",
      },
      thirdDisease: {
        code: "",
        name: "",
      },
      fourthDisease: {
        code: "",
        name: "",
      },
    },
    nationalityState: {
      nationality: "",
      nationalityStateCode: "",
    },
  },
};

export const registerPatient = createAsyncThunk(
  "user/registerPatient",
  async (
    { id, personalInformation, diseaseHistorial, nationalityState },
    thunkAPI
  ) => {
    try {
      const response = await PatientService.registerPatient(
        id,
        personalInformation,
        diseaseHistorial,
        nationalityState
      );
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

const patientSlice = createSlice({
  name: "patient",
  initialState,
  extraReducers: {
    [registerPatient.pending]: (state, action) => {
      state.loading = true;
    },
    [registerPatient.fulfilled]: (state, action) => {
      state.loading = false;
    },
    [registerPatient.rejected]: (state, action) => {
      state.loading = false;
    },
  },
});

const { reducer } = patientSlice;
export default reducer;
