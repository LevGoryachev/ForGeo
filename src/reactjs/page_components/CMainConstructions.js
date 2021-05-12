import Headline from "./Headline";
import Link from "next/link";
import React, { useContext, useState, useEffect } from 'react'
import {ForGeoContext} from "../stores/store";
import {constructionDel} from "../pages/constructions";
import {CRUDconstructions} from "../service_components/CRUDConstructions";


const cMainConstructions = (props) => {

    const {constructionsx, updConstructions} = useContext(ForGeoContext);
    const [constructionsxState, updConstructionsState] = useState(constructionsx);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);
        CRUDconstructions.getAll()
            .then((d) => {
                updConstructionsState(d);
            })
            .then((d) => console.log(d))
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
                            <button className="buttonblick"
                                onClick={
                                    () => {const opt = confirm("Delete this from DB?");
                                        if (opt){
                                            constructionDel(construction.id)
                                                .then(() => {
                                                    CRUDconstructions.getAll()
                                                        .then((d) => {
                                                            updConstructionsState(d);
                                                        })
                                                        .then((d) => console.log(d))
                                                        .catch((err) => {
                                                        console.log(err);
                                                        });
                                                });
                                        }
                                    }
                                } >DELETE
                            </button>
                        </td>
                        <td>
                            <Link href={`/constructions/edit/${construction.id}`}>
                                <button>EDIT</button>
                            </Link>
                        </td>
                    </tr>
                )}
            </table>
            <p>
                <Link href={`/constructions/create`}>
                    <button className="buttonblick">ADD NEW</button>
                </Link>
            </p>
        </div>
    );

};
export default cMainConstructions;