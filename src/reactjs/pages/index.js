import AHeader from "../page_components/AHeader";
import BSideBar from "../page_components/BSideBar";
import CMainHome from "../page_components/CMainHome";
import DClear from "../page_components/DClear";
import EFooter from "../page_components/EFooter";

const Index = () => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainHome />
            <DClear />
            <EFooter />
        </div>
    );
};

export default Index;