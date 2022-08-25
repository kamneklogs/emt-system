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
import { parse, isDate } from "date-fns";
import { useNavigate } from "react-router-dom";

const Register = () => {
  const navigate = useNavigate();
  const [successful, setSuccessful] = useState(false);
  const dispatch = useDispatch();
  const initialValues = {
    firstName: "",
    lastName: "",
    email: "",
    dob: "",
    genre: {
      value: "Otro",
    },
    civilStatus: {
      value: "Otro",
    },
    phone: "",
  };

  const handleRegister = (formValue) => {
    /* const { firstName, email, password } = formValue;
    setSuccessful(false);
    dispatch(register({ firstName, email, password }))
      .unwrap()
      .then(() => {
        setSuccessful(true);
      })
      .catch((error) => {
        setSuccessful(false);
      });*/
    console.log(formik.values);
    console.log(formik.errors);
    console.log(successful);
  };

  const validationSchema = Yup.object({
    firstName: Yup.string().required("Este campo es requerido"),
    lastName: Yup.string().required("Este campo es requerido"),
    dob: Yup.date()
      .transform(function (value, originalValue) {
        if (this.isType(value)) {
          return value;
        }
        const result = parse(originalValue, "dd.MM.yyyy", new Date());
        return result;
      })
      .typeError("please enter a valid date")
      .required()
      .min("1969-11-13", "Date is too early"),
    email: Yup.string()
      .email("Invalid email format")
      .required("Este campo es requerido"),
    phone: Yup.number().required("Este campo es requerido"),
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
                <h4>Crear cuenta para un usuario</h4>
                <hr />
                <Form onSubmit={formik.handleSubmit}>
                  <Row className="py-2">
                    <Col lg={6} md={12} sm={12}>
                      <Form.Group className="mb-3" controlId="firstName">
                        <Form.Label>Nombre</Form.Label>
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
                        <Form.Label>Apellido</Form.Label>
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
                        <Form.Label>Fecha de nacimiento</Form.Label>
                        <Form.Control
                          type="date"
                          name={formik.values.dob}
                          onChange={formik.handleChange}
                          placeholder="Date of Birth"
                        />
                      </Form.Group>
                    </Col>
                    <Col lg={6} md={12} sm={12}>
                      <div className="mb-2">Género</div>
                      <Form.Group controlId="genre">
                        <Form.Select
                          name="genre.value"
                          onChange={formik.handleChange}
                        >
                          <option value="female">Femenino</option>
                          <option value="male">Masculino</option>
                          <option value="other">Otro</option>
                        </Form.Select>
                      </Form.Group>
                    </Col>
                  </Row>
                  <Row>
                    <Col lg={12} md={12} sm={12}>
                      <Form.Group className="mb-3" controlId="email">
                        <Form.Label>Correo electrónico</Form.Label>
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
                      <div className="mb-2">Estado civil</div>
                      <Form.Group controlId="civilStatus">
                        <Form.Select
                          name="civilStatus.value"
                          onChange={formik.handleChange}
                          className="mb-2"
                        >
                          <option value="soltero">Soltero</option>
                          <option value="casado">Casado</option>
                          <option value="other">Otro</option>
                        </Form.Select>
                      </Form.Group>
                    </Col>
                    <Col lg={6} md={12} sm={12}>
                      <Form.Group className="mb-3" controlId="phone">
                        <Form.Label>Número de teléfono</Form.Label>
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

                  <Button type="submit">Siguiente</Button>
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
              <Button variant="outline-primary" onClick={() => navigate(-1)}>
                Siguiente
              </Button>
            </Col>
          </Row>
        </div>
      )}
    </Container>
  );
};

export default Register;
