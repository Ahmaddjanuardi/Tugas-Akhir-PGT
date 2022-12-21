import registerPage from "./pages/Register.vue";
import homePage from "./pages/Home.vue";
import tambahkkPage from "./pages/TambahKK.vue";
import detaikKKPage from "./pages/DetailKK.vue";
import detailAKPage from "./pages/DetailAK.vue";
import formDetailAK from "./pages/DetailEditAK.vue"




export default[
    {
        path: "/",
        component: registerPage,
        name:'Selamat Datang'
    },
    {
        path: "/home",
        component: homePage,
        name: 'Homepage'
    },
    {
        path: "/addKK",
        component: tambahkkPage,
        name: 'TambahKK'
    },
    {
        path: "/detailKK/:id",
        component: detaikKKPage, 
        name: 'DetailKK'
    },
    {
        path: "/detailKK/:id/listAnggota",
        component: detailAKPage,  
        name: 'DetailAK'
    },
    {
        path: "/detailKK/:id/listAnggota/detailAnggota/:idAnggota",
        component: formDetailAK,
        name: "formDetailAK"

    },
]