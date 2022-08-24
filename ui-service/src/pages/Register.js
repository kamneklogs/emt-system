import React, { useState } from "react";
import { useDispatch } from "react-redux";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useFormik } from "formik";
import { Alert } from "react-bootstrap";
import { register } from "../slices/auth";
import * as Yup from "yup";
import { useNavigate } from "react-router-dom";

const Register = () => {
  const navigate = useNavigate();
  const [successful, setSuccessful] = useState(false);
  const dispatch = useDispatch();
  const initialValues = {
    username: "",
    email: "",
    password: "",
  };

  const handleRegister = (formValue) => {
    const { username, email, password } = formValue;
    setSuccessful(false);
    dispatch(register({ username, email, password }))
      .unwrap()
      .then(() => {
        setSuccessful(true);
      })
      .catch((error) => {
        setSuccessful(false);
      });
  };

  const validationSchema = Yup.object({
    username: Yup.string().required("Required"),
    email: Yup.string().email("Invalid email format").required("Required"),
    password: Yup.string().required("Required"),
  });
  const formik = useFormik({
    initialValues,
    onSubmit: handleRegister,
    validationSchema,
  });

  return (
    <Container>
      {!successful && (
        <Row>
          <Col lg="5" md="10" sm="10" className="mx-auto">
            <Card className="mt-5 mb-5">
              <Card.Body>
                <h4>Crear cuenta para un usuario</h4>
                <hr />
                <Form onSubmit={formik.handleSubmit}>
                  <Form.Group className="mb-3" controlId="username">
                    <Form.Label>Usuario</Form.Label>
                    <Form.Control
                      type="text"
                      placheholder="e.g JohnDoe19"
                      value={formik.values.username}
                      onChange={formik.handleChange}
                      onBlur={formik.handleBlur}
                      isInvalid={
                        formik.errors.username && formik.touched.username
                      }
                    ></Form.Control>
                    {formik.errors.username && formik.touched.username ? (
                      <Alert className="mt-3" variant="danger">
                        {formik.errors.username}
                      </Alert>
                    ) : null}
                  </Form.Group>
                  <Form.Group className="mb-3" controlId="email">
                    <Form.Label>Correo electrónico</Form.Label>
                    <Form.Control
                      type="email"
                      placheholder="test@test.com"
                      value={formik.values.email}
                      onChange={formik.handleChange}
                      onBlur={formik.handleBlur}
                      isInvalid={formik.errors.email && formik.touched.email}
                    ></Form.Control>
                    {formik.errors.email && formik.touched.email ? (
                      <Alert className="mt-3" variant="danger">
                        {formik.errors.email}
                      </Alert>
                    ) : null}
                  </Form.Group>

                  <Form.Group className="mb-3" controlId="password">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                      type="password"
                      placheholder="********"
                      value={formik.values.password}
                      onChange={formik.handleChange}
                      onBlur={formik.handleBlur}
                      isInvalid={
                        formik.errors.password && formik.touched.password
                      }
                    ></Form.Control>
                    {formik.errors.password && formik.touched.password ? (
                      <Alert className="mt-3" variant="danger">
                        {formik.errors.password}
                      </Alert>
                    ) : null}
                  </Form.Group>

                  <Button type="submit">Crear cuenta</Button>
                </Form>
              </Card.Body>
            </Card>
            <Button variant="outline-primary" onClick={() => navigate(-1)}>
              Go back
            </Button>
          </Col>
        </Row>
      )}
      {successful && (
        <div className="alert">
          <Row>
            <Col lg="5" md="10" sm="10" className="mx-auto">
              <Alert variant="success">Usuario creado exitosamente!</Alert>
              <Button variant="outline-primary" onClick={() => navigate(-1)}>
                Go back
              </Button>
            </Col>
          </Row>
        </div>
      )}
    </Container>
  );
};

export default Register;
