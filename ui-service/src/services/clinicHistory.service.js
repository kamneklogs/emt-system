import axios from "axios";
import authHeader from "./auth-header";

const API_URL = "http://localhost:8080/";
const CLINIC_HISTORY_URL = "clinicalhistoryformat";

export const saveClinicHistoryModel = (data) => {
  return axios.post(API_URL + CLINIC_HISTORY_URL, data, {
    headers: authHeader(),
  });
};

export const getClinicHistoryWithQuestions = (uuid) => {
  return axios.get(API_URL);
};
