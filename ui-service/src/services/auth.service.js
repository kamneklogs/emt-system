import axios from "axios";

const API_URL = "http://localhost:8080/public/auth/";

const register = (username, email, password) => {
  return axios.post(API_URL + "signup", { username, email, password });
};
const login = (username, password) => {
  return axios
    .post(API_URL + "login", { username, password })
    .then((response) => {
      //console.log(response.data.authorities.length === 1 ? "si" : "no");
      if (response.data.authorities.length === 0) {
        throw new Error("Este usuario no tiene roles asociados");
      }
      if (response.data.token) {
        localStorage.setItem("user", JSON.stringify(response.data));
      }
      return response.data;
    });
};
const logout = () => {
  localStorage.removeItem("user");
};

const authService = {
  register,
  login,
  logout,
};
export default authService;
