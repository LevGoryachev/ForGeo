import {useForm} from "react-hook-form";
import Headline from "./Headline";
import React, {useContext, useState} from "react";
import {CRUDconstructions} from "../service_components/CRUDConstructions";
import {ForGeoContext} from "../stores/store";
import Router from 'next/router';

const CMainEdit = (props) => {

    const construction = props.getById;

    const {constructionsx, updConstructions} = useContext(ForGeoContext);
    const [constructionsxState, updConstructionsState] = useState(constructionsx);
    const {register, handleSubmit, formState: {errors}} = useForm({mode: 'onBlur'});


    const constructionAsyncUpd = async (id, data) => {
        return await CRUDconstructions.update(id, data);
    };

    const onSubmit = (data) => {
        const opt = confirm("Save changes to DB?");
            if (opt){
                constructionAsyncUpd(construction.id, data)
                    .then((d) => {
                        Router.push(`/constructions/${construction.id}`).then(d => console.log(d));
                    })
                    .then(() => {
                        CRUDconstructions.getAll()
                            .then((d) => {
                                updConstructionsState(d);
                            })
                            .then((d) => console.log(d))
                            .catch((err) => {
                                console.log(err);
                            });
                        //window.location.href='/constructions'
                    });
            }
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
                            <td><input title="Code-Number" defaultValue={construction.codeNumber} type="text" name="codeNumber" {...register('codeNumber')}/></td>
                            <td><input title="Name" defaultValue={construction.name} type="text" name="name" {...register('name')}/></td>
                        </tr>
                    </tbody>
                    <thead>
                        <tr>
                            <td><h3>Description</h3></td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td><textarea title="Description" defaultValue={construction.description} name="description" {...register('description')}/></td>
                        </tr>
                    </tbody>
                </table>
                <button className="buttonblick" type="submit">SUBMIT</button>
            </form>
        </div>
    );
};
export default CMainEdit;