import {useForm} from "react-hook-form";
import Headline from "./Headline";
import React, {useContext, useState, useCallback} from "react";
import {CRUDconstructions} from "../service_components/CRUDConstructions";
import {ForGeoContext} from "../stores/store";
import {constructionPost} from "../pages/constructions/create";
import Router from 'next/router';

const CMainCreate = (props) => {

    const {constructionsx, updConstructions} = useContext(ForGeoContext);
    const [constructionsxState, updConstructionsState] = useState(constructionsx);
    const {register, handleSubmit, formState: {errors}} = useForm({mode: 'onBlur'});

    const onSubmit = (data) => {
        constructionPost(data)
            .then(() => {
                CRUDconstructions.getAll()
                    .then((x) => {
                        updConstructionsState(x);
                    })
                    .then((y) => {
                        Router.push("/constructions").then(y => console.log(y));
                    })
                    .then((y) => console.log(y))
                    .catch((err) => {
                        console.log(err);
                    });
                //window.location.href='/constructions'
            });

        console.log(data);
    };

    return (
        <div id="c_main">
            <Headline />
            <h4>Add new construction site</h4>
            <form onSubmit={handleSubmit(onSubmit)}>
                <table className="maintable">
                    <thead>
                        <tr>
                            <td><h3>Code-number</h3></td>
                            <td><h3>Name (project or construction site name)</h3></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><input title="Code-Number" type="text" name="codeNumber" {...register('codeNumber')}/></td>
                            <td><input title="Name" type="text" name="name" {...register('name')}/></td>
                        </tr>
                    </tbody>
                    <thead>
                        <tr>
                            <td><h3>Description</h3></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><textarea title="Description" name="description" {...register('description')}/></td>
                        </tr>
                    </tbody>
                </table>
                <button className="buttonblick" type="submit">SUBMIT</button>
            </form>
        </div>
    );
};
export default CMainCreate;