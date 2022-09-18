import React, { useEffect, useState } from "react";
import { Button, Card, Col, Container, Form, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { getUserByUsername } from "../slices/user";
import { clearMessage } from "../slices/message";
import UserService from "../services/user.service";

const EditUser = () => {
  const params = useParams();
  const username = params.userId;
  const [roles, setRoles] = useState([]);
  const { loading, user } = useSelector((state) => state.user);
  const [enableEdit, setEnableEdit] = useState(true);

  const dispatch = useDispatch();

  useEffect(() => {
    UserService.getAllRoles().then((data) => {
      setRoles(data);
    });
    dispatch(getUserByUsername(username));
    dispatch(clearMessage());
  }, [username, setRoles, dispatch]);

  //función para tener los arreglos de los roles solo con su nombre
  const rolesName = (rolesObject) => {
    let rolesarray = [];
    for (const element of rolesObject) {
      rolesarray.push(element.name);
    }
    return rolesarray;
  };
  //función para encontrar los roles en común entre los roles de la app y los roles del usuario
  const findRolesInCommon = (rolesApp, rolesUser) => {
    return rolesApp.filter((role) => rolesUser.includes(role));
  };

  const setButtonToEdit = () => {
    setEnableEdit(!enableEdit);
  };

  const handleAddRoleToUser = (roleName) => {
    UserService.addRoleToAUser(roleName, user.username).then((data) => {
      console.log(data);
      window.location.reload();
    });
  };
  const handleDeleteRoleToUser = (roleName) => {
    UserService.deleteRoleToAUser(roleName, user.username);
    //window.location.reload();
  };

  return (
    <Container>
      {!loading ? (
        <Row>
          <Col lg="10" md="10" sm="10" className="mx-auto">
            <Card className="mt-5 mb-5 shadow-lg p-1">
              <Card.Body>
                <Card.Title>
                  <h3>
                    <strong>Editar Usuario</strong>
                  </h3>
                </Card.Title>
                <hr />
                <Card>
                  <Card.Title className="ms-4 mt-4">
                    <h4>
                      <strong>Información del usuario</strong>
                    </h4>
                  </Card.Title>
                  <Card.Body className="ms-2">
                    <h5>
                      <strong>Roles del usuario:</strong>
                    </h5>
                    {user.roles.length !== 0 ? (
                      <Form.Group>
                        <Row>
                          {findRolesInCommon(
                            rolesName(roles),
                            rolesName(user.roles)
                          ).map((role) => (
                            <Col
                              className="mx-2"
                              lg={12}
                              sm={12}
                              md={12}
                              key={role}
                            >
                              <Form.Check
                                type="checkbox"
                                className="mx-2"
                                name="userRoles"
                                value={role}
                                label={role}
                                defaultChecked={true}
                                disabled={true}
                              />
                            </Col>
                          ))}
                        </Row>
                      </Form.Group>
                    ) : (
                      <div>
                        <h6>Este usuario no tiene roles asociados</h6>
                      </div>
                    )}
                    <hr />
                    {enableEdit ? (
                      <div className="d-flex flex-row-reverse">
                        <Button
                          variant="outline-primary"
                          onClick={setButtonToEdit}
                        >
                          Editar
                        </Button>
                      </div>
                    ) : (
                      <>
                        <Form>
                          <h6>
                            Elimine o agregue los roles que va a tener el
                            usuario: <strong>{user.username}</strong>
                          </h6>
                          <ul className="list-group mx-2">
                            {roles.map((role) => (
                              <li
                                key={role.name}
                                className="list-group-item d-flex justify-content-between align-items-start"
                              >
                                <div className="ms-2 me-auto">
                                  <div className="fw-bold">{role.name}</div>
                                  {role.description}
                                </div>
                                <Button
                                  className="badge rounded-pill mt-3"
                                  variant={
                                    findRolesInCommon(
                                      rolesName(roles),
                                      rolesName(user.roles)
                                    ).includes(role.name)
                                      ? "danger"
                                      : "success"
                                  }
                                  onClick={
                                    findRolesInCommon(
                                      rolesName(roles),
                                      rolesName(user.roles)
                                    ).includes(role.name)
                                      ? () => handleDeleteRoleToUser(role.name)
                                      : () => handleAddRoleToUser(role.name)
                                  }
                                >
                                  {findRolesInCommon(
                                    rolesName(roles),
                                    rolesName(user.roles)
                                  ).includes(role.name)
                                    ? "Eliminar"
                                    : "Agregar"}
                                </Button>
                              </li>
                            ))}
                          </ul>
                          <div className="mt-4">
                            <div className="d-flex flex-row-reverse">
                              <Button
                                variant="outline-primary"

                                // onClick={setButtonToEdit}
                              >
                                Guardar cambios
                              </Button>
                            </div>
                          </div>
                        </Form>
                      </>
                    )}
                  </Card.Body>
                </Card>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      ) : (
        <Row>
          <Col lg="10" md="10" sm="10" className="mx-auto">
            <Card className="mt-5 mb-5 shadow-lg p-1">
              <Card.Body>
                <Card.Title>
                  <h3>
                    <strong>Cargando información del usuario</strong>
                  </h3>
                </Card.Title>
                <hr />
                <Card></Card>
              </Card.Body>
            </Card>
          </Col>
        </Row>
      )}
    </Container>
  );
};

export default EditUser;
