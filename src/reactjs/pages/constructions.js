import AHeader from "../components/AHeader";
import BSideBar from "../components/BSideBar";
import CMainConstructions from "../components/CMainConstructions";
import DClear from "../components/DClear";
import EFooter from "../components/EFooter";
import {CRUDconstructions} from "../service_components/CRUDConstructions";
import React, { useContext, useState } from 'react'
import {ForGeoContext} from "../stores/store";

const Constructions = ({constructionsData}) => {
    const {constructionsx, updConstructions} = useContext(ForGeoContext);
    console.log(constructionsx);
    return (
        <div id="container">
            <AHeader />
            <BSideBar />
            <CMainConstructions getCon = {constructionsx} updCon = {updConstructions}/>
            <DClear />
            <EFooter />
        </div>
    );
};
export default Constructions;

/*export async function getStaticProps(context) {
    const constructionsData = await CRUDconstructions.getAll();
    console.log(constructionsData);
    return {
        props: {constructionsData} // will be passed to the page component as props
    }
}*/

/*export async function getStaticProps(ForGeoContext) {

    const constructionsData = constructionsx;
    console.log(constructionsData);
    return {
        props: {constructionsData} // will be passed to the page component as props
    }
}*/

export const newNumber = 15;

/*export async function updateData(ForGeoContext) {

    const constructionsData = await CRUDconstructions.getAll();
    return {
        props: {constructionsData}
    }
}*/


export async function constructionDel(id) {
    await CRUDconstructions.delete(id);
}
