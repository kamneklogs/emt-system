import React, { useState } from "react";
import { Button, Card, Col, Form, Row } from "react-bootstrap";
import * as FiIcons from "react-icons/fi";

const EditUserPersonalInformation = ({ user }) => {
  const actualUser = user;
  const [editText, setEditText] = useState(true);
  const [isDisabled, setIsDisable] = useState(true);

  const handleEditInformation = () => {
    setEditText(!editText);
    setIsDisable(!isDisabled);
  };
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
                    <Col lg={10} md={8} sm={8}>
                      <Form.Control
                        type="text"
                        value=""
                        disabled={isDisabled}
                      ></Form.Control>
                    </Col>
                    <Col lg={2} md={4} sm={4} className="users-table-controls">
                      <span>
                        <FiIcons.FiEdit></FiIcons.FiEdit>
                      </span>
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
                    <Col lg={10} md={8} sm={8}>
                      <Form.Control
                        type="text"
                        value=""
                        disabled={isDisabled}
                      ></Form.Control>
                    </Col>
                    <Col lg={2} md={4} sm={4} className="users-table-controls">
                      <span>
                        <FiIcons.FiEdit></FiIcons.FiEdit>
                      </span>
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
                    value=""
                    disabled={isDisabled}
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
                    value=""
                    disabled={isDisabled}
                  />
                </Form.Group>
              </Col>
            </Row>
          </Form>
          <hr />
          <div className="d-flex flex-row-reverse">
            <Button variant="outline-primary" onClick={handleEditInformation}>
              {editText ? "Editar" : "Guardar Cambios"}
            </Button>
          </div>
        </Card.Body>
      </Card>
    </>
  );
};

export default EditUserPersonalInformation;
