import AHeader from "../../page_components/AHeader";
import BSideBar from "../../page_components/BSideBar";
import DClear from "../../page_components/DClear";
import EFooter from "../../page_components/EFooter";
import {CRUDconstructions} from "../../service_components/CRUDConstructions";
import CMainCreate from "../../page_components/CMainCreate";

const Constructions = () => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainCreate />
            <DClear />
            <EFooter />
        </div>
    );
};
export default Constructions;

export async function constructionPost(data) {
    await CRUDconstructions.create(data);
}