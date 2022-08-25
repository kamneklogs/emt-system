import "./App.css";
import Sidebar from "./components/Sidebar";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Overview from "./pages/Overview";
import { Reports, ReportsOne, ReportsTwo, ReportsThree } from "./pages/Reports";
import Login from "./pages/Login";
import ProtectedRoutes from "./components/ProtectedRoutes";
import PublicRoutes from "./components/PublicRoutes";
import Product from "./pages/Product";
import Register from "./pages/Register";
import RegisterPersonalInfo from "./pages/RegisterPersonalInfo";
function App() {
  return (
    <Router>
      <Sidebar />
      <Routes>
        <Route path="/" element={<ProtectedRoutes />}>
          <Route path="/overview" element={<Overview />}>
            <Route
              path="/overview/users"
              element={<RegisterPersonalInfo />}
            ></Route>
          </Route>
          <Route path="/reports" element={<Reports />}></Route>
          <Route path="/reports/reports1" element={<ReportsOne />}></Route>
          <Route path="/reports/reports2" element={<ReportsTwo />}></Route>
          <Route path="/reports/reports3" element={<ReportsThree />}></Route>
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
