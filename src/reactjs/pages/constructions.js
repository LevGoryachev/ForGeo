import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import CMainConstructions from "../components/CMainConstructions";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";

const Constructions = () => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainConstructions />
            <DClear />
            <EFooter />
        </div>
    );
};

export default Constructions;