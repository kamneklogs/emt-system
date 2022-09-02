import React from "react";
import * as FaIcons from "react-icons/fa";
import * as AiIcons from "react-icons/ai";
import * as IoIcons from "react-icons/io";
import * as RiIcons from "react-icons/ri";

export const SidebarData = [
  {
    title: "Login",
    path: "/login",
    roles: ["ADMIN", "MEDICO"],
  },
  {
    title: "Overview",
    path: "/overview",
    icon: <AiIcons.AiFillHome />,
    roles: ["ADMIN_ROLE"],
    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,
    subNav: [
      {
        title: "Users",
        path: "/overview/users",
        icon: <IoIcons.IoIosPaper />,
      },
      {
        title: "User register",
        path: "/overview/userRegister",
        icon: <IoIcons.IoIosPaper />,
      },
      {
        title: "Pacients",
        path: "/overview/revenue",
        icon: <IoIcons.IoIosPaper />,
      },
      {
        title: "Emt Users",
        path: "/overview/emtUsers",
        icon: <IoIcons.IoIosPaper />,
      },
    ],
  },
  {
    title: "Reports",
    path: "/reports",
    icon: <AiIcons.AiFillHome />,
    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,
    roles: ["ADMIN_ROLE"],
    subNav: [
      {
        title: "Reports",
        path: "/reports/reports1",
        icon: <IoIcons.IoIosPaper />,
      },
      {
        title: "Reports 2",
        path: "/reports/reports2",
        icon: <IoIcons.IoIosPaper />,
      },
      {
        title: "Reports 3",
        path: "/reports/reports3",
        icon: <IoIcons.IoIosPaper />,
      },
    ],
  },
  // {
  //   title: "Products",
  //   path: "/products",
  //   icon: <FaIcons.FaCartPlus />,
  //   roles: ["DOCTOR_ROLE"],
  // },
  {
    title: "Team",
    path: "/team",
    icon: <IoIcons.IoMdPeople />,
    roles: ["DOCTOR_ROLE"],
  },
  {
    title: "Messages",
    path: "/messages",
    icon: <FaIcons.FaEnvelopeOpenText />,
    roles: ["DOCTOR_ROLE"],

    iconClosed: <RiIcons.RiArrowDownSFill />,
    iconOpened: <RiIcons.RiArrowUpSFill />,

    subNav: [
      {
        title: "Message 1",
        path: "/messages/message1",
        icon: <IoIcons.IoIosPaper />,
      },
      {
        title: "Message 2",
        path: "/messages/message2",
        icon: <IoIcons.IoIosPaper />,
      },
    ],
  },
  {
    title: "Support",
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
