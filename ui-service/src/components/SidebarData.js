import React from "react";
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as IoIcons from "react-icons/io";
import * as RiIcons from "react-icons/ri";
import * as HiIcons from "react-icons/hi";
import * as ImIcons from "react-icons/im";

export const SidebarData = [
  {
    title: "Iniciar Sesión",
    path: "/login",
    roles: ["ADMIN", "MEDICO"],
  },
  {
    title: "Gestión de Usuarios",
    path: "/users",
    icon: <FaIcons.FaUsers />,
    roles: ["ADMIN_ROLE"],
    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,
    subNav: [
      {
        title: "Registro de Usuarios",
        path: "/users/userRegister",
        icon: <HiIcons.HiUserAdd />,
      },

      {
        title: "Usuarios del EMT",
        path: "/users/emtUsers",
        icon: <HiIcons.HiUsers />,
      },
    ],
  },
  {
    title: "Gestión de Roles",
    path: "/roles",
    icon: <FaIcons.FaUserLock />,
    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,
    roles: ["ADMIN_ROLE"],
    subNav: [
      {
        title: "Registro de Roles",
        path: "/roles/reports1",
        icon: <ImIcons.ImUserPlus />,
      },
      {
        title: "Roles del EMT",
        path: "/roles/reports2",
        icon: <IoIcons.IoIosPaper />,
      },
      {
        title: "Reports 3",
        path: "/roles/reports3",
        icon: <IoIcons.IoIosPaper />,
      },
    ],
  },
  {
    title: "Gestion de Pacientes",
    path: "/team",
    icon: <IoIcons.IoMdPeople />,
    roles: ["DOCTOR_ROLE"],
  },
  {
    title: "Gestión de Historias Clínicas",
    path: "/messages",
    icon: <FaIcons.FaEnvelopeOpenText />,
    roles: ["DOCTOR_ROLE"],

    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,

    subNav: [
      {
        title: "Formatos de historias clínicas",
        path: "/messages/message1",
        icon: <IoIcons.IoIosPaper />,
      },
      {
        title: "Historias clínicas del sistema",
        path: "/messages/message2",
        icon: <IoIcons.IoIosPaper />,
      },
    ],
  },
  {
    title: "Soporte",
    path: "/support",
    icon: <IoIcons.IoMdHelpCircle />,
    roles: ["DOCTOR_ROLE"],
  },
  {
    title: "Logout",
    path: "/logout",
    roles: ["ADMIN_ROLE", "DOCTOR_ROLE"],
  },
];
