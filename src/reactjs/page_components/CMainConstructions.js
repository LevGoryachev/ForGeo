import Headline from "./Headline";
import Link from "next/link";
import React, { useContext, useState, useEffect } from 'react'
import {ForGeoContext, getAsyncData, getSyncData, getSyncInitDataInMemory, getSyncState} from "../stores/store";
import Constructions, {constructionDel, getOne, getStaticProps, newNumber, updateData} from "../pages/constructions";
import {CRUDconstructions} from "../service_components/CRUDConstructions";


const cMainConstructions = (props) => {

    const {constructionsx, updConstructions} = useContext(ForGeoContext);

    const [constructionsxState, updConstructionsState] = useState(constructionsx);

    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        CRUDconstructions.getAll()
            .then((x) => {
                updConstructionsState(x);
            })
            .then((x) => console.log(x))
            .catch((err) => {
                console.log(err);
            })
            .finally(() => {
                setLoading(false);
            });

    }, []);

    if (loading) {
        return (
        <div id="c_main">
            <Headline />
            <p>Data is loading...</p>;
        </div>
        )
    }

    return (
        <div id="c_main">
            <Headline />
            {/*<p>{language}</p>*/}
            <table border="1" cellPadding="5">
                <tr>
                    <td width="100px">Database ID</td>
                    <td width="200px">CODE-NUMBER</td>
                    <td width="200px">Name of project</td>
                    <td colSpan="2">EDIT DATA</td>
                </tr>
                {constructionsxState.map((construction) =>
                    <tr>
                        <td width="100px">{construction.id}</td>
                        <td width="200px">{construction.codeNumber}</td>
                        <td width="500px">
                            <Link href={`/constructions/${construction.id}`}>
                                <a>{construction.name}</a>
                            </Link>
                        </td>
                        <td>
                            <button onClick={() => {constructionDel(construction.id)
                                .then(() => {
                                CRUDconstructions.getAll()
                                    .then((x) => {
                                        updConstructionsState(x);
                                    })
                                    .then((y) => console.log(y))
                                    .catch((err) => {
                                        console.log(err);
                                    });
                                //window.location.href='/constructions'
                            });}}>DELETE</button>
                        </td>
                        <td>

                            <button onClick={() => {CRUDconstructions.getAll()
                                .then((x) => {
                                    updConstructionsState(x);
                                })
                                .then((y) => console.log(y))
                                .catch((err) => {
                                    console.log(err);
                                });}}>CHK Context</button>

                        </td>
                    </tr>
                )}
            </table>
        </div>
    );

};
export default cMainConstructions;