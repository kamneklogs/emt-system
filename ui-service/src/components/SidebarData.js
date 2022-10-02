export const SidebarData = [
  {
    title: "Iniciar Sesión",
    name: "login",
    path: "/login",
    roles: ["ADMIN", "medical_staff"],
  },
  {
    title: "Gestión de Usuarios",
    name: "users_list",
    path: "/users",
    roles: ["ADMIN", "medical_staff"],
    subNav: [
      {
        title: "Registro de Usuarios",
        path: "/users/userRegister",
      },

      {
        title: "Usuarios del EMT",
        path: "/users/emtUsers",
      },
    ],
  },
  {
    title: "Gestión de Roles",
    name: "roles_list",
    path: "/roles",
    roles: ["ADMIN"],
    subNav: [
      {
        title: "Registro de Roles",
        path: "/roles/rolesRegister",
      },
      {
        title: "Roles del EMT",
        path: "/roles/emtRoles",
      },
    ],
  },
  {
    title: "Gestion de Pacientes",
    name: "pacients_list",
    path: "/pacients",
    roles: ["ADMIN", "medical_staff", "nursing_staff"],
  },
  {
    title: "Gestión de Historias Clínicas",
    path: "/clinicHistory",
    name: "clinical_history_list",
    roles: ["ADMIN", "medical_staff", "nursing_staff"],
    subNav: [
      {
        title: "Formatos de historias clínicas",
        path: "/clinicHistory/models",
      },
      {
        title: "Historias clínicas del sistema",
        path: "/clinicHistory/pacients",
      },
    ],
  },
  {
    title: "Soporte",
    path: "/support",
    name: "support",
    roles: ["ADMIN", "medical_staff", "nursing_staff", "administrative_staff"],
  },
  {
    title: "Cerrar Sesión",
    name: "logout",
    path: "/logout",
    roles: ["ADMIN", "medical_staff", "nursing_staff", "administrative_staff"],
  },
];
