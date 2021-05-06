import {useForm} from "react-hook-form";
import Headline from "./Headline";
import React, {useContext, useState, useCallback} from "react";
import {CRUDconstructions} from "../service_components/CRUDConstructions";
import {ForGeoContext} from "../stores/store";
import {constructionPost} from "../pages/constructions/create";

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
                    .then((y) => console.log(y))
                    .catch((err) => {
                        console.log(err);
                    });
                //window.location.href='/constructions'
            });
        console.log(data)
    }

    return (
        <div id="c_main">
            <Headline />
            <h4>Signup from sample (third)</h4>
            <form onSubmit={handleSubmit(onSubmit)}>
                <input title="Name" name="name" {...register('name')} />
                <input title="Code-Number of construction" name="codeNumber" {...register('codeNumber')} />
                <input title="Description" name="description" {...register('description')} />
                <button type="submit" >SUB</button>
            </form>
        </div>
    );
}
export default CMainCreate;