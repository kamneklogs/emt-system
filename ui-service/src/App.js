import "./App.css";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import UserManagment from "./pages/user/UserManagment";
import RoleManagment from "./pages/RoleManagment";
import Login from "./pages/Login";
import ProtectedRoutes from "./components/ProtectedRoutes";
import PublicRoutes from "./components/PublicRoutes";
import Register from "./pages/user/Register";
import UserView from "./pages/user/UserView";
import EditUser from "./pages/user/EditUser";
import UserRecoverPassword from "./pages/user/UserRecoverPassword";
import NavbarMenu from "./components/NavbarMenu";
import UserDetails from "./pages/user/UserDetails";
import PatientManagment from "./pages/pacient/PatientManagment";
import PatientRegister from "./pages/pacient/PatientRegister";
import ClinicHistoryManagment from "./pages/clinicHistory/ClinicHistoryManagment";
import CreateClinicHistory from "./pages/clinicHistory/clinicHistoryFormat/CreateClinicHistory";
import ClinicHistoryView from "./pages/clinicHistory/clinicHistoryCreatedFormats/ClinicHistoryView";
import PatientView from "./pages/pacient/PatientView";
import PatientDetails from "./pages/pacient/PatientDetails";

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
          <Route path="/patients" element={<PatientManagment />}>
            <Route
              path="/patients/patientRegister"
              element={<PatientRegister />}
            ></Route>
            <Route
              path="/patients/emtPatients"
              element={<PatientView />}
            ></Route>
            <Route
              path="/patients/patientDetails/:patientId"
              element={<PatientDetails />}
            ></Route>
          </Route>
          <Route path="/clinicHistory" element={<ClinicHistoryManagment />}>
            <Route
              path="/clinicHistory/createClinicHistory"
              element={<CreateClinicHistory />}
            ></Route>
            <Route
              path="/clinicHistory/clinicHistoryFormats"
              element={<ClinicHistoryView />}
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
