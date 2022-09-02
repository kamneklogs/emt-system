import React, { useEffect, useState } from "react";
import { Col, Container, Row, Table } from "react-bootstrap";
import UserService from "../services/user.service";
import { List, Share, Trash } from "react-bootstrap-icons";

const UserView = () => {
  const [users, setUsers] = useState([]);
  useEffect(() => {
    UserService.getAllUsers().then(
      (response) => {
        setUsers(response.data);
        console.log(response.data);
      },
      (error) => {
        const _content =
          (error.response && error.response.data) ||
          error.message ||
          error.toString();
        setUsers(_content);
      }
    );
  }, [setUsers]);

  const renderTable = () => {
    return (
      <Table className="mt-4 users-table" striped bordered hover responsive>
        <thead>
          <tr>
            <th>Id</th>
            <th>Last login</th>
            <th>Acciones</th>
          </tr>
        </thead>
        <tbody>
          {users.map((user) => {
            return (
              <tr key={user.username}>
                <td>{user.username}</td>
                <td>{user.last_login}</td>
                <td className="users-table-controls">
                  <span>
                    <Trash></Trash>
                  </span>
                </td>
              </tr>
            );
          })}
        </tbody>
      </Table>
    );
  };
  return (
    <Container className="mt-5">
      <Row>
        <Col sm="10" md="10" lg="8" className="mx-auto">
          <h2>Usuarios</h2>
          {renderTable()}
        </Col>
      </Row>
    </Container>
  );
};

export default UserView;
