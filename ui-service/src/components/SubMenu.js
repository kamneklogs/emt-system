import React, { useCallback, useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { Link, useNavigate } from "react-router-dom";
import styled from "styled-components";
import { logout } from "../slices/auth";
import EventBus from "../common/EventBus";

const SidebarLink = styled(Link)`
  display: flex;
  color: #e1e9fc;
  justify-content: space-between;
  align-items: center;
  padding: 20px;
  list-style: none;
  height: 60px;
  text-decoration: none;
  font-size: 18px;

  &:hover {
    background: #023e8a;
    border-left: 4px solid #03045e;
    cursos: pointer;
  }
`;
const SidebarLabel = styled.span`
  margin-left: 16px;
`;

const DropdownLink = styled(Link)`
  background: #0096c7;
  height: 60px;
  padding-left: 3rem;
  display: flex;
  align-items: center;
  text-decoration: none;
  color: #f5f5f5;
  font-size: 18px;

  &:hover {
    background: #90e0ef;
    cursor: pointer;
    color: #00b4d8;
  }
`;
const SubMenu = ({ item }) => {
  const [showModeratorBoard, setShowModeratorBoard] = useState(false);
  const [showAdminMoard, setShowAdminMoard] = useState(false);

  const { user: currentUser } = useSelector((state) => state.auth);
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const logOut = useCallback(() => {
    console.log("logout");
    navigate("/login");
    dispatch(logout());
  }, [dispatch]);

  useEffect(() => {
    if (currentUser) {
      let rolModerator = false;
      let rolAdmin = false;
      for (const element of currentUser.authorities) {
        if (element.authority === "DOCTOR_ROLE") {
          rolModerator = true;
        } else if (element.authority === "ADMIN_ROLE") {
          rolAdmin = true;
        }
      }
      setShowModeratorBoard(rolModerator);
      setShowAdminMoard(rolAdmin);
    }
    EventBus.on("logout", () => {
      logOut();
    });
    return () => {
      EventBus.remove("logout");
    };
  }, [currentUser, logOut]);

  const [subnav, setSubnav] = useState(false);
  const showSubnav = () => setSubnav(!subnav);
  return (
    <>
      {/*showAdminMoard && item.roles.includes("ADMIN_ROLE") ? (
        <SidebarLink to={item.path} onClick={item.subNav && showSubnav}>
          <div>
            {item.icon}
            <SidebarLabel onClick={item.title === "Logout" ? logOut : null}>
              {item.title}
            </SidebarLabel>
          </div>
          <div>
            {item.subNav && subnav
              ? item.iconOpened
              : item.subNav
              ? item.iconClosed
              : null}
          </div>
        </SidebarLink>
      ) : null*/}
      {currentUser && item.title !== "Login" && item.title !== "Logout" ? (
        <SidebarLink to={item.path} onClick={item.subNav && showSubnav}>
          <div>
            {item.icon}
            <SidebarLabel>{item.title}</SidebarLabel>
          </div>
          <div>
            {item.subNav && subnav
              ? item.iconOpened
              : item.subNav
              ? item.iconClosed
              : null}
          </div>
        </SidebarLink>
      ) : null}
      {!currentUser && item.title === "Login" ? (
        <SidebarLink to={item.path} onClick={item.subNav && showSubnav}>
          <div>
            {item.icon}
            <SidebarLabel>{item.title}</SidebarLabel>
          </div>
          <div>
            {item.subNav && subnav
              ? item.iconOpened
              : item.subNav
              ? item.iconClosed
              : null}
          </div>
        </SidebarLink>
      ) : null}

      {currentUser &&
        subnav &&
        item.subNav.map((item, index) => {
          return (
            <DropdownLink to={item.path} key={index}>
              {item.icon}
              <SidebarLabel>{item.title}</SidebarLabel>
            </DropdownLink>
          );
        })}
    </>
  );
};
export default SubMenu;
