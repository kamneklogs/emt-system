import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./slices/auth";
import messageReducer from "./slices/message";
import userReducer from "./slices/user";
import featureReducer from "./slices/feature";
import patientReducer from "./slices/patient";

const reducer = {
  auth: authReducer,
  user: userReducer,
  message: messageReducer,
  feature: featureReducer,
  patient: patientReducer,
};

const store = configureStore({
  reducer: reducer,
  devTools: true,
});
export default store;
