import React, { useState } from "react";
import { Button, Card, Col, Form, Row } from "react-bootstrap";

const EditUserContactInformation = ({ user }) => {
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
                    disabled={isDisabled}
                  />
                </Form.Group>
              </Col>
              <Col lg={6} md={12} sm={12}>
                <Form.Group controlId="email">
                  <Form.Label>
                    <strong>Correo electrónico:</strong>
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

export default EditUserContactInformation;
