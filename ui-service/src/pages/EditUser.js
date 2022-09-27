import React, { useEffect, useState } from "react";
import Tab from "react-bootstrap/Tab";
import Tabs from "react-bootstrap/Tabs";
import { Card, Col, Container, Row } from "react-bootstrap";
import { useParams } from "react-router-dom";
import { useDispatch, useSelector } from "react-redux";
import { getUserByUsername } from "../slices/user";
import { clearMessage } from "../slices/message";
import UserService from "../services/user.service";
import EditUserPersonalInformation from "./EditUserPersonalInformation";
import EditUserRoles from "./EditUserRoles";
import EditUserContactInformation from "./EditUserContactInformation";
import EditUserStatus from "./EditUserStatus";

const EditUser = () => {
  const params = useParams();
  const username = params.userId;
  const [roles, setRoles] = useState([]);
  const { loading, user } = useSelector((state) => state.user);

  const dispatch = useDispatch();

  useEffect(() => {
    UserService.getAllRoles().then((data) => {
      setRoles(data);
    });
    dispatch(getUserByUsername(username));
    dispatch(clearMessage());
  }, [username, setRoles, dispatch]);

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
                  <hr />
                </Card.Title>
                <Tabs
                  defaultActiveKey="personalInformation"
                  id="fill-tab-example"
                  className="mb-3"
                  fill
                >
                  <Tab
                    eventKey="personalInformation"
                    title="Información Personal"
                  >
                    <EditUserPersonalInformation user={user} />
                  </Tab>
                  <Tab
                    eventKey="contactInformation"
                    title="Información de Contacto"
                  >
                    <EditUserContactInformation user={user} roles={roles} />
                  </Tab>
                  <Tab eventKey="roles" title="Roles">
                    <EditUserRoles user={user} roles={roles} />
                  </Tab>
                  <Tab eventKey="status" title="Estado del Usuario">
                    <EditUserStatus user={user} roles={roles} />
                  </Tab>
                </Tabs>
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
