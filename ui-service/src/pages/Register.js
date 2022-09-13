import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Card from "react-bootstrap/Card";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useFormik } from "formik";
import { Alert } from "react-bootstrap";
import { register } from "../slices/user";
import * as Yup from "yup";
import UserService from "../services/user.service";
import { useNavigate } from "react-router-dom";

const Register = () => {
  const navigate = useNavigate();
  const [roles, setRoles] = useState([]);
  const [successful, setSuccessful] = useState(false);
  const { message } = useSelector((state) => state.message);

  useEffect(() => {
    UserService.getAllRoles().then((data) => {
      setRoles(data);
    });
  }, [setRoles]);
  const dispatch = useDispatch();
  const initialValues = {
    username: "",
    email: "",
    password: "",
    firstName: "",
    lastName: "",
    dob: "",
    genre: {
      value: "",
    },
    civilStatus: {
      value: "",
    },
    phone: "",
    userRoles: [],
  };

  const handleRegister = (formValue) => {
    const { username, password } = formValue;
    setSuccessful(false);
    dispatch(register({ username, password }))
      .unwrap()
      .then(() => {
        setSuccessful(true);
      })
      .catch((error) => {
        setSuccessful(false);
      });
    console.log(formik.values);
  };

  const validationSchema = Yup.object({
    username: Yup.string().required("Required"),
    email: Yup.string().email("Invalid email format").required("Required"),
    password: Yup.string().required("Required"),
    firstName: Yup.string().required("Required"),
    lastName: Yup.string().required("Required"),
    phone: Yup.string().required("Required"),
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
          <Col lg="8" md="10" sm="10" className="mx-auto">
            <Card className="mt-5 mb-5 shadow-lg p-1">
              <Card.Body>
                <h3>Crear cuenta para un usuario</h3>
                <hr />
                <h4>Información de usuario</h4>
                <Form onSubmit={formik.handleSubmit}>
                  <Row className="py-2">
                    <Col lg={12} md={12} sm={12}>
                      <Form.Group className="mb-3" controlId="email">
                        <Form.Label>
                          <strong>Correo electrónico</strong>
                        </Form.Label>
                        <Form.Control
                          type="email"
                          placheholder="test@test.com"
                          value={formik.values.email}
                          onChange={formik.handleChange}
                          onBlur={formik.handleBlur}
                          isInvalid={
                            formik.errors.email && formik.touched.email
                          }
                        ></Form.Control>
                        {formik.errors.email && formik.touched.email ? (
                          <Alert className="mt-3" variant="danger">
                            {formik.errors.email}
                          </Alert>
                        ) : null}
                      </Form.Group>
                    </Col>
                  </Row>
                  <Row>
                    <Col lg={6} md={12} sm={12}>
                      <Form.Group className="mb-3" controlId="username">
                        <Form.Label>
                          <strong>Usuario</strong>
                        </Form.Label>
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
                    </Col>
                    <Col lg={6} md={12} sm={12}>
                      <Form.Group className="mb-3" controlId="password">
                        <Form.Label>
                          <strong>Contraseña</strong>
                        </Form.Label>
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
                    </Col>
                  </Row>
                  <hr />
                  <h4>Información personal</h4>
                  <Row className="py-2">
                    <Col lg={6} md={12} sm={12}>
                      <Form.Group className="mb-3" controlId="firstName">
                        <Form.Label>
                          <strong>Nombre</strong>
                        </Form.Label>
                        <Form.Control
                          type="text"
                          placeholder="e.g Rodrigo"
                          value={formik.values.firstName}
                          onChange={formik.handleChange}
                          onBlur={formik.handleBlur}
                          isInvalid={
                            formik.errors.firstName && formik.touched.firstName
                          }
                        ></Form.Control>
                        {formik.errors.firstName && formik.touched.firstName ? (
                          <Alert className="mt-3" variant="danger">
                            {formik.errors.firstName}
                          </Alert>
                        ) : null}
                      </Form.Group>
                    </Col>

                    <Col lg={6} md={12} sm={12}>
                      <Form.Group className="mb-3" controlId="lastName">
                        <Form.Label>
                          <strong>Apellido</strong>
                        </Form.Label>
                        <Form.Control
                          type="text"
                          placeholder="e.g Osorio"
                          value={formik.values.lastName}
                          onChange={formik.handleChange}
                          onBlur={formik.handleBlur}
                          isInvalid={
                            formik.errors.lastName && formik.touched.lastName
                          }
                        ></Form.Control>
                        {formik.errors.lastName && formik.touched.lastName ? (
                          <Alert className="mt-3" variant="danger">
                            {formik.errors.lastName}
                          </Alert>
                        ) : null}
                      </Form.Group>
                    </Col>
                  </Row>
                  <Row className="pb-2">
                    <Col lg={6} md={12} sm={12}>
                      <Form.Group controlId="dob">
                        <Form.Label>
                          <strong>Fecha de nacimiento</strong>
                        </Form.Label>
                        <Form.Control
                          type="date"
                          name={formik.values.dob}
                          onChange={formik.handleChange}
                          onBlur={formik.handleBlur}
                          placeholder="Date of Birth"
                        />
                      </Form.Group>
                    </Col>
                    <Col lg={6} md={12} sm={12}>
                      <div className="mb-2">
                        <strong>Género</strong>
                      </div>
                      <Form.Group controlId="genre">
                        <Form.Select
                          name="genre.value"
                          onChange={formik.handleChange}
                        >
                          <option value="">Seleccione una opción</option>
                          <option value="female">Femenino</option>
                          <option value="male">Masculino</option>
                          <option value="other">Otro</option>
                        </Form.Select>
                      </Form.Group>
                    </Col>
                  </Row>
                  <Row>
                    <Col lg={6} md={12} sm={12}>
                      <div className="mt-3">
                        <strong>Estado civil</strong>
                      </div>
                      <Form.Group controlId="civilStatus">
                        <Form.Select
                          name="civilStatus.value"
                          onChange={formik.handleChange}
                          className="mt-2"
                        >
                          <option value="">Seleccione una opción</option>
                          <option value="soltero">Soltero</option>
                          <option value="casado">Casado</option>
                          <option value="other">Otro</option>
                        </Form.Select>
                      </Form.Group>
                    </Col>
                    <Col lg={6} md={12} sm={12}>
                      <Form.Group className="my-3" controlId="phone">
                        <Form.Label>
                          <strong>Número de teléfono</strong>
                        </Form.Label>
                        <Form.Control
                          type="number"
                          value={formik.values.phone}
                          onChange={formik.handleChange}
                          onBlur={formik.handleBlur}
                          isInvalid={
                            formik.errors.phone && formik.touched.phone
                          }
                        ></Form.Control>
                        {formik.errors.phone && formik.touched.phone ? (
                          <Alert className="mt-3" variant="danger">
                            {formik.errors.phone}
                          </Alert>
                        ) : null}
                      </Form.Group>
                    </Col>
                  </Row>
                  <Row>
                    <div className="mb-2">
                      <strong>Rol del usuario:</strong>
                    </div>
                    {roles.map((role) => (
                      <Col lg={12} sm={12} md={12} key={role.name}>
                        <Form.Check
                          type="checkbox"
                          className="mx-2"
                          name="userRoles"
                          value={role.name}
                          label={`${role.name}: ${role.description} `}
                          onChange={formik.handleChange}
                        />
                      </Col>
                    ))}
                  </Row>
                  <hr />
                  <div className="d-flex flex-row-reverse">
                    <Button variant="outline-primary" type="submit">
                      Crear cuenta
                    </Button>
                  </div>
                </Form>
              </Card.Body>
            </Card>
            <Button
              variant="outline-primary"
              onClick={() => navigate("/users/userRegister")}
            >
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
              <Button
                variant="outline-primary"
                onClick={() => navigate("/users/emtUsers")}
              >
                Go back
              </Button>
            </Col>
          </Row>
        </div>
      )}
      {message && (
        <div className="alert">
          <Row>
            <Col lg="8" md="10" sm="10" className="mx-auto">
              <Alert variant="danger">{message}</Alert>
            </Col>
          </Row>
        </div>
      )}
    </Container>
  );
};

export default Register;
