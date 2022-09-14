import React, { useEffect, useState } from "react";
import { Col, Container, Row } from "react-bootstrap";
import { Trash } from "react-bootstrap-icons";
import { useDispatch, useSelector } from "react-redux";
import { getAllUsers } from "../slices/user";
import { clearMessage } from "../slices/message";

import BootstrapTable from "react-bootstrap-table-next";
import "bootstrap/dist/css/bootstrap.min.css";
import "react-bootstrap-table-next/dist/react-bootstrap-table2.css";
import paginationFactory from "react-bootstrap-table2-paginator";
import "react-bootstrap-table2-paginator/dist/react-bootstrap-table2-paginator.min.css";
import filterFactory, { textFilter } from "react-bootstrap-table2-filter";
import "react-bootstrap-table2-filter/dist/react-bootstrap-table2-filter.min.css";
import * as FiIcons from "react-icons/fi";
import * as RiIcons from "react-icons/ri";
import ModalUser from "./ModalUser";
import { useNavigate } from "react-router-dom";

const UserView = () => {
  const { loading, usersApp } = useSelector((state) => state.user);
  const [show, setShow] = useState(false);
  const [userId, setUserId] = useState();
  const navigate = useNavigate();
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(clearMessage());
    dispatch(getAllUsers());
  }, [dispatch]);
  const handleClose = () => {
    setShow(false);
    console.log(userId);
    console.log(loading);
  };
  const handleShow = (username) => {
    setShow(true);
    setUserId(username);
  };

  const handleEditUser = (username) => {
    navigate(`/users/editUser/${username}`);
  };

  const actionsButtons = (cell, row, rowIndex, formatExtraData) => {
    return (
      <Container>
        <Row className="users-table-controls">
          <Col lg={3} md={12} sm={12} className="me-1">
            <span
              onClick={() => {
                handleEditUser(row.username);
              }}
            >
              <FiIcons.FiEdit></FiIcons.FiEdit>
            </span>
          </Col>

          <Col lg={3} md={12} sm={12} className="me-1">
            <span onClick={() => handleShow(row.username)}>
              <Trash></Trash>
            </span>
          </Col>
          <Col lg={3} md={12} sm={12} className="me-1">
            <span>
              <RiIcons.RiLockPasswordLine></RiIcons.RiLockPasswordLine>
            </span>
          </Col>
        </Row>
      </Container>
    );
  };
  const userStateToggle = (cell, row, rowIndex, formatExtraData) => {
    return (
      <Container>
        <Row className="users-table-controls">
          <Col>Activo</Col>
        </Row>
      </Container>
    );
  };
  const columns = [
    {
      dataField: "username",
      text: "Username",
      sort: true,
      filter: textFilter(),
    },
    {
      dataField: "last_login",
      text: "Last login",
      sort: true,
      filter: textFilter(),
    },
    {
      datafield: "userState",
      text: "Estado del usuario",
      formatter: userStateToggle,
    },
    {
      dataField: "actions",
      text: "Acciones",
      formatter: actionsButtons,
    },
  ];
  const pagination = paginationFactory({
    page: 1,
    sizePerPage: 5,
    lastPageText: ">>",
    firstPageText: "<<",
    nextPageText: ">",
    prePageText: "<",
    showTotal: true,
    alwaysShowAllBtns: true,
    onPageChange: function (page, sizePerPage) {
      console.log("page", page);
      console.log("sizePerPage", sizePerPage);
    },
    onSizePerPageChange: function (page, sizePerPage) {
      console.log("page", page);
      console.log("sizePerPage", sizePerPage);
    },
  });
  const renderTable = () => {
    return (
      <>
        <BootstrapTable
          className="mt-4 users-table text-center"
          responsive
          striped
          hover
          bootstrap4
          keyField="username"
          columns={columns}
          data={usersApp}
          pagination={pagination}
          filter={filterFactory()}
        ></BootstrapTable>
      </>
    );
  };
  return (
    <>
      <Container className="mt-5">
        <Row>
          <Col sm="10" md="10" lg="10" className="mx-auto">
            <h2 className="mb-5 text-center">
              <strong>Usuarios del EMT</strong>
            </h2>
            {renderTable()}
          </Col>
        </Row>
      </Container>
      <ModalUser
        show={show}
        handleClose={() => handleClose()}
        userId={userId}
      />
    </>
  );
};

export default UserView;
