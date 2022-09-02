import axios from "axios";
import authHeader from "./auth-header";
const API_URL = "http://localhost:8080/";

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
  return axios.get(API_URL + "user", { headers: authHeader() });
};

const getAllRoles = () => {
  return axios.get(API_URL + "role", { headers: authHeader() });
};
const userService = {
  getPublicContent,
  getUserBoard,
  getModeratorBoard,
  getAdminBoard,
  getAllUsers,
  getAllRoles,
};
export default userService;
