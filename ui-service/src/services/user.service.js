import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/";
const API_USER = "user";
const API_ROLE = "role";
const API_AUTH = "auth";
const API_PASSWORD = "password";
const API_STATUS = "status";

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
  return axios
    .delete(`${API_URL}${API_ROLE}/${roleName}/${API_USER}/${username}`, {
      headers: authHeader(),
    })
    .then((response) => {
      return response.data;
    });
};
const changePassword = (username, password) => {
  return axios
    .put(
      `${API_URL}public/${API_AUTH}/${API_PASSWORD}`,
      { username, password },
      { headers: authHeader() }
    )
    .then((response) => {
      return response.data;
    });
};

// var data = "true";
// var config = {
//   method: "put",
//   url: "http://localhost:8080/user/1010138801/status",
//   headers: authHeader(),
//   data: data,
// };

const editUserStatus = (username, isEnabled) => {
  return axios
    .put(`${API_URL}${API_USER}/${username}/${API_STATUS}`, isEnabled, {
      headers: authHeader(),
    })
    .then((response) => {
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
  changePassword,
  editUserStatus,
};
export default userService;
