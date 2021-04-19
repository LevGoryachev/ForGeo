import AHeader from "../../components/AHeader";
import BSideBar from "../../components/BSideBar";
import CMainConstructionById from "../../components/CMainConstructionById";
import DClear from "../../components/DClear";
import EFooter from "../../components/EFooter";

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
    const response = await fetch(`http://localhost:8080/Gradle___ru_goryachev___ForGeo_war/api/v2/constructions/${params.id}`)
    const OneConstruction = await response.json()
    console.log(params);
    return {
        props: {OneConstruction}, // will be passed to the page component as props
    }
}
