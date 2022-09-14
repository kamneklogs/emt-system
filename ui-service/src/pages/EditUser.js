import React, { useEffect, useState } from "react";
import { Card, Col, Container, Form, Row } from "react-bootstrap";
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
  const dispatch = useDispatch();

  useEffect(() => {
    UserService.getAllRoles().then((data) => {
      setRoles(data);
    });
    dispatch(clearMessage());
    dispatch(getUserByUsername(username));
  }, [setRoles, dispatch, username]);

  console.log(user);
  return (
    <Container>
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
                  <Form.Group></Form.Group>
                </Card.Body>
              </Card>
            </Card.Body>
          </Card>
        </Col>
      </Row>
    </Container>
  );
};

export default EditUser;
