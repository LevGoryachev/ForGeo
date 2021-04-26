import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import CMainConstructions from "../components/CMainConstructions";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";
import {CRUDconstructions} from "../service_components/CRUDConstructions";

const Constructions = ({constructionsData}) => {
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainConstructions getCon = {constructionsData}/>
            <DClear />
            <EFooter />
        </div>
    );
};
export default Constructions;

export async function getStaticProps(context) {
    const constructionsData = await CRUDconstructions.getAll();
    console.log(constructionsData);
    return {
        props: {constructionsData} // will be passed to the page component as props
    }
}
