import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import Navbar from "react-bootstrap/Navbar";
import NavDropdown from "react-bootstrap/NavDropdown";
import Offcanvas from "react-bootstrap/Offcanvas";
import { SidebarData } from "./SidebarData";
import { useDispatch, useSelector } from "react-redux";
import emt from "./../img/emt.png";
import { useNavigate } from "react-router-dom";
import { useCallback, useEffect } from "react";
import { logout } from "../slices/auth";
import EventBus from "../common/EventBus";
import { Button } from "react-bootstrap";
import { getAllFeatures } from "../slices/feature";

function NavbarC() {
  const { features } = useSelector((state) => state.feature);
  const { user: currentUser } = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const logOut = useCallback(() => {
    console.log("logout");
    navigate("/login");
    dispatch(logout());
  }, [dispatch, navigate]);
  useEffect(() => {
    dispatch(getAllFeatures());
    EventBus.on("logout", () => {
      logOut();
    });
    return () => {
      EventBus.remove("logout");
    };
  }, [currentUser, dispatch, logOut]);

  const verify = () => {
    for (let i = 0; i < features.length; i++) {
      //console.log(features[i].rolesWithAccess);
      currentUser.authorities.forEach((userRol) => {
        const existeEnRoles = features[i].rolesWithAccess.find(
          (rol) => rol === userRol.authority
        );
        if (existeEnRoles) {
          console.log(features[i].name, "existe");
        } else {
          console.log(features[i].name, "no existe");
        }
      });
    }
  };
  //verify();

  return (
    <>
      {[false].map((expand) => (
        <Navbar
          key={expand}
          bg="light"
          expand={expand}
          className="mb-3 navbarcolor"
        >
          <Container fluid>
            <Navbar.Brand href="#home">
              <h5>Emt system</h5>
            </Navbar.Brand>
            <Navbar.Toggle aria-controls={`offcanvasNavbar-expand-${expand}`} />
            <Navbar.Offcanvas
              side="left"
              id={`offcanvasNavbar-expand-${expand}`}
              aria-labelledby={`offcanvasNavbarLabel-expand-${expand}`}
            >
              <Offcanvas.Header closeButton>
                <Offcanvas.Title id={`offcanvasNavbarLabel-expand-${expand}`}>
                  <strong>EMT SYSTEM</strong>
                </Offcanvas.Title>
              </Offcanvas.Header>
              <Offcanvas.Body>
                <Nav className="justify-content-end flex-grow-1 pe-3">
                  {SidebarData.map((item) => {
                    if (
                      currentUser &&
                      item.title !== "Iniciar Sesión" &&
                      item.title !== "Cerrar Sesión" &&
                      item.subNav
                    ) {
                      return (
                        <NavDropdown
                          className="my-navbar"
                          title={item.title}
                          id={`offcanvasNavbarDropdown-expand-${expand}`}
                          key={item.title}
                        >
                          {item.subNav.map((itemsubnav) => (
                            <NavDropdown.Item
                              href={itemsubnav.path}
                              key={itemsubnav.title}
                            >
                              {itemsubnav.title}
                            </NavDropdown.Item>
                          ))}
                        </NavDropdown>
                      );
                    } else if (
                      item.title !== "Iniciar Sesión" &&
                      item.title !== "Cerrar Sesión" &&
                      currentUser &&
                      !item.subNav
                    ) {
                      return (
                        <Nav.Link
                          className="my-navbar-link"
                          href={item.path}
                          key={item.title}
                        >
                          {item.title}
                        </Nav.Link>
                      );
                    } else if (currentUser && item.title === "Cerrar Sesión") {
                      return (
                        <Button
                          className="mx-2"
                          variant="outline-dark"
                          size="sm"
                          onClick={logOut}
                          key={item.title}
                        >
                          {item.title}
                        </Button>
                      );
                    }
                  })}
                </Nav>
              </Offcanvas.Body>
            </Navbar.Offcanvas>
          </Container>
        </Navbar>
      ))}
    </>
  );
}

export default NavbarC;
