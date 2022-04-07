export default [
    {
        //dashboard
        path: "dashboard",
        component: () => import("@/pages/dashboard/MainDashBoard.vue")
    },
    {
        path:"list",
        component: () => import("@/pages/dashboard/List.vue")
    },
    

];