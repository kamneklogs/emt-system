import "./App.css";
import Sidebar from "./components/Sidebar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import UserManagment from "./pages/UserManagment";
import RoleManagment from "./pages/RoleManagment";
import Login from "./pages/Login";
import ProtectedRoutes from "./components/ProtectedRoutes";
import PublicRoutes from "./components/PublicRoutes";
import Product from "./pages/Product";
import Register from "./pages/Register";
import RegisterPersonalInfo from "./pages/RegisterPersonalInfo";
import UserView from "./pages/UserView";
function App() {
  return (
    <Router>
      <Sidebar />
      <Routes>
        <Route path="/" element={<ProtectedRoutes />}>
          <Route path="/users" element={<UserManagment />}>
            <Route path="/users/userRegister" element={<Register />}></Route>
            <Route path="/users/emtUsers" element={<UserView />}></Route>
          </Route>
          <Route path="/roles" element={<RoleManagment />}></Route>
          <Route path="/products" element={<Product />}></Route>
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
