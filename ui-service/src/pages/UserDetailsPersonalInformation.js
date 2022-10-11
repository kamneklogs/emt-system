import React, { useEffect } from "react";
import { Card, Col, Form, Row } from "react-bootstrap";

const UserDetailsPersonalInformation = ({ user, userPersonalInformation }) => {
  const actualUser = user;
  const actualUserPersonalInformation = userPersonalInformation;

  useEffect(() => {}, []);
  return (
    <>
      <Card>
        <Card.Title className="ms-4 mt-4">
          <h4>
            <strong>
              Información básica del usuario {actualUser.username}
            </strong>
          </h4>
        </Card.Title>
        <Card.Body className="ms-2">
          <h5>
            <strong>Información personal:</strong>
          </h5>
          <Form>
            <Row className="py-2">
              <Col lg={6} md={12} sm={12}>
                <Form.Group className="mb-3" controlId="firstName">
                  <Form.Label>
                    <strong>Nombre:</strong>
                  </Form.Label>
                  <Row>
                    <Col lg={12} md={8} sm={8}>
                      <Form.Control
                        type="text"
                        value={actualUserPersonalInformation.firstName}
                        disabled={true}
                      ></Form.Control>
                    </Col>
                  </Row>
                </Form.Group>
              </Col>
              <Col lg={6} md={12} sm={12}>
                <Form.Group className="mb-3" controlId="lastName">
                  <Form.Label>
                    <strong>Apellido:</strong>
                  </Form.Label>
                  <Row>
                    <Col lg={12} md={8} sm={8}>
                      <Form.Control
                        type="text"
                        value={actualUserPersonalInformation.lastName}
                        disabled={true}
                      ></Form.Control>
                    </Col>
                  </Row>
                </Form.Group>
              </Col>
            </Row>
            <Row className="pb-2">
              <Col lg={6} md={12} sm={12}>
                <Form.Group controlId="dob">
                  <Form.Label>
                    <strong>Fecha de nacimiento:</strong>
                  </Form.Label>
                  <Form.Control
                    type="text"
                    name=""
                    value={actualUserPersonalInformation.birthDate}
                    disabled={true}
                  />
                </Form.Group>
              </Col>
              <Col lg={6} md={12} sm={12}>
                <Form.Group controlId="genre">
                  <Form.Label>
                    <strong>Género:</strong>
                  </Form.Label>
                  <Form.Control
                    type="text"
                    name=""
                    value={actualUserPersonalInformation.gender.name}
                    disabled={true}
                  />
                </Form.Group>
              </Col>
            </Row>
          </Form>
        </Card.Body>
      </Card>
    </>
  );
};

export default UserDetailsPersonalInformation;
