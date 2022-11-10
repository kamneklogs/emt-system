import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { clearMessage } from "../../slices/message";
import { getAllPatients } from "../../slices/patient";

const PatientView = () => {
  const { patients } = useSelector((state) => state.patient);
  const [show, setShow] = useState(false);
  const dispatch = useDispatch();

  useEffect(() => {
    dispatch(clearMessage());
    dispatch(getAllPatients());
  }, [dispatch]);

  const columns = [
    {
      dataField: "",
    },
  ];
  return <div>PatientView</div>;
};

export default PatientView;
