import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import UserManagment from "./pages/UserManagment";
import RoleManagment from "./pages/RoleManagment";
import Login from "./pages/Login";
import ProtectedRoutes from "./components/ProtectedRoutes";
import PublicRoutes from "./components/PublicRoutes";
import Register from "./pages/Register";
import UserView from "./pages/UserView";
import EditUser from "./pages/EditUser";
import UserRecoverPassword from "./pages/UserRecoverPassword";
import NavbarMenu from "./components/NavbarMenu";
import UserDetails from "./pages/UserDetails";

function App() {
  return (
    <Router>
      <NavbarMenu />
      <Routes>
        <Route path="/" element={<ProtectedRoutes />}>
          <Route path="/users" element={<UserManagment />}>
            <Route path="/users/userRegister" element={<Register />}></Route>
            <Route path="/users/emtUsers" element={<UserView />}></Route>
            <Route
              path="/users/editUser/:userId"
              element={<EditUser />}
            ></Route>
            <Route
              path="/users/userDetails/:userId"
              element={<UserDetails />}
            ></Route>
            <Route
              path="/users/recoverPassword/:userId"
              element={<UserRecoverPassword />}
            ></Route>
          </Route>
          <Route path="/roles" element={<RoleManagment />}></Route>
          <Route path="/logout"></Route>
        </Route>
        <Route path="login" element={<PublicRoutes />}>
          <Route path="/login" element={<Login />}></Route>
        </Route>
      </Routes>
    </Router>
  );
}

export default App;
