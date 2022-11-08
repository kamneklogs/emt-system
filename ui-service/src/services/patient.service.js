import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/";
const API_PATIENT = "patient";

const registerPatient = (
  id,
  personalInformation,
  diseaseHistorial,
  nationalityState
) => {
  return axios.post(
    API_URL + API_PATIENT,
    {
      id,
      personalInformation,
      diseaseHistorial,
      nationalityState,
    },
    { headers: authHeader() }
  );
};

const patientService = {
  registerPatient,
};
export default patientService;
