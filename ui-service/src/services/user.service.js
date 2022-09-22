import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/";
const API_USER = "user";
const API_ROLE = "role";

const getPublicContent = () => {
  return axios.get(API_URL + "all");
};

const getUserBoard = () => {
  return axios.get(API_URL + "user", { headers: authHeader() });
};
const getModeratorBoard = () => {
  return axios.get(API_URL + "user", { headers: authHeader() });
};
const getAdminBoard = () => {
  return axios.get(API_URL + "user", { headers: authHeader() });
};

const getAllUsers = () => {
  return axios
    .get(API_URL + API_USER, { headers: authHeader() })
    .then((response) => {
      return response.data;
    });
};

const getAllRoles = () => {
  return axios
    .get(API_URL + API_ROLE, { headers: authHeader() })
    .then((response) => {
      return response.data;
    });
};

const register = (username, password, rolesIds) => {
  return axios.post(
    API_URL + API_USER,
    { username, password, rolesIds },
    { headers: authHeader() }
  );
};

const getUserByUsername = (username) => {
  return axios
    .get(`${API_URL}${API_USER}/${username}`, { headers: authHeader() })
    .then((response) => {
      return response.data;
    });
};

const addRoleToAUser = (roleName, username) => {
  return axios
    .post(
      `${API_URL}${API_ROLE}/${roleName}/${API_USER}/${username}`,
      {},
      {
        headers: authHeader(),
      }
    )
    .then((response) => {
      return response.data;
    });
};
const deleteRoleToAUser = (roleName, username) => {
   return axios.delete(
    `${API_URL}${API_ROLE}/${roleName}/${API_USER}/${username}`,
    {
      headers: authHeader(),
    }
  ).then((response) => {
    return response.data;
  });
  
};
const userService = {
  getPublicContent,
  getUserBoard,
  getModeratorBoard,
  getAdminBoard,
  register,
  getAllUsers,
  getAllRoles,
  getUserByUsername,
  addRoleToAUser,
  deleteRoleToAUser,
};
export default userService;
