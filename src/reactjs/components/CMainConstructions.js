import Headline from "./Headline";
import Link from "next/link";
import React, { useContext, useState } from 'react'
import {ForGeoContext} from "../stores/store";

const Constructions = (props) => {

    const value = useContext(ForGeoContext);

    return (
        <div id="c_main">
            <Headline />
            <p>{value}</p>
            <table border="1" cellPadding="5">
                <tr>
                    <td width="100px">Database ID</td>
                    <td width="200px">CODE-NUMBER</td>
                    <td width="200px">Name of project</td>
                    <td colSpan="2">EDIT DATA</td>
                </tr>
                {props.getCon.map((construction) =>
                    <tr>
                        <td width="100px">{construction.id}</td>
                        <td width="200px">{construction.codeNumber}</td>
                        <td width="500px">
                            <Link href={`/constructions/${construction.id}`}>
                                <a>{construction.name}</a>
                            </Link>
                        </td>

                        <td>

                        </td>

                    </tr>
                )}
            </table>

        </div>
    );
};
export default Constructions;