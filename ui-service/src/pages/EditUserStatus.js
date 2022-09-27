import React, { useState } from "react";
import { Button, Card } from "react-bootstrap";

const EditUserStatus = ({ user }) => {
  const actualUser = user;
  const [editText, setEditText] = useState(true);
  const [isDisabled, setIsDisable] = useState(true);

  const handleEditInformation = () => {
    setEditText(!editText);
    setIsDisable(!isDisabled);
  };
  console.log(actualUser.accountStatus);
  return (
    <>
      <Card>
        <Card.Title className="ms-4 mt-4">
          <h4>
            <strong>
              Información del estado del usuario {actualUser.username}
            </strong>
          </h4>
        </Card.Title>
        <Card.Body className="ms-2">
          <h5>
            <strong>Estado actual del usuario: {actualUser.username}</strong>.
          </h5>
          {actualUser.accountStatus ? (
            <h5>
              Actualmente el usuario se encuentra <strong>activo</strong>.
            </h5>
          ) : (
            <h5>
              Actualmente el usuario se encuentra <strong>inactivo</strong>
            </h5>
          )}
          <div className="d-flex flex-row-reverse">
            <Button variant="outline-primary" onClick={handleEditInformation}>
              {actualUser.accountStatus
                ? "Desactivar cuenta"
                : "Activar cuenta"}
            </Button>
          </div>

          <hr />
        </Card.Body>
      </Card>
    </>
  );
};

export default EditUserStatus;
