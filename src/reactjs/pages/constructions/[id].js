import AHeader from "../../components/AHeader";
import BSideBar from "../../components/BSideBar";
import CMainConstructionById from "../../components/CMainConstructionById";
import DClear from "../../components/DClear";
import EFooter from "../../components/EFooter";
import {CRUDconstructions} from "../../service_components/CRUDConstructions";

const Constructions = ({OneConstruction}) => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainConstructionById getById = {OneConstruction}/>
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
