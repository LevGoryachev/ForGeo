import AHeader from "../../../page_components/AHeader";
import BSideBar from "../../../page_components/BSideBar";
import DClear from "../../../page_components/DClear";
import EFooter from "../../../page_components/EFooter";
import {CRUDconstructions} from "../../../service_components/CRUDConstructions";
import CMainEdit from "../../../page_components/CMainEdit";


const Constructions = ({OneConstruction}) => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainEdit getById = {OneConstruction} />
            <DClear />
            <EFooter />
        </div>
    );
};
export default Constructions;

export async function getServerSideProps({params}) {
    const OneConstruction = await CRUDconstructions.getById(params.id);
    console.log(params);
    return {
        props: {OneConstruction}, // will be passed to the page component as props
    }
}