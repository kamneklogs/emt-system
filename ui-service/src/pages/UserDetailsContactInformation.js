import React from "react";
import { Card, Col, Form, Row } from "react-bootstrap";

const UserDetailsContactInformation = ({ user }) => {
  const actualUser = user;

  return (
    <>
      <Card>
        <Card.Title className="ms-4 mt-4">
          <h4>
            <strong>
              Información de contacto del usuario {actualUser.username}
            </strong>
          </h4>
        </Card.Title>
        <Card.Body className="ms-2">
          <h5>
            <strong>Información de contacto:</strong>
          </h5>
          <Form>
            <Row className="pb-2">
              <Col lg={6} md={12} sm={12}>
                <Form.Group controlId="phone">
                  <Form.Label>
                    <strong>Teléfono:</strong>
                  </Form.Label>
                  <Form.Control
                    type="number"
                    name=""
                    value=""
                    disabled={true}
                  />
                </Form.Group>
              </Col>
              <Col lg={6} md={12} sm={12}>
                <Form.Group controlId="email">
                  <Form.Label>
                    <strong>Correo electrónico:</strong>
                  </Form.Label>
                  <Form.Control type="text" name="" value="" disabled={true} />
                </Form.Group>
              </Col>
            </Row>
          </Form>
        </Card.Body>
      </Card>
    </>
  );
};

export default UserDetailsContactInformation;
