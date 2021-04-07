import {useRouter} from "next/router";

export default function Construction({construction}) {
    const {query} = useRouter()
    return (
            <div id = "construction">
                <h1>Construction id: {query.id}</h1>
                <div>Name: {construction.codeNumber}</div>
                <div>Name: {construction.name}</div>
                <div>Name: {construction.description}</div>
            </div>
    )
};

export async function getServerSideProps({params}) {
    const response = await fetch(`https:/forgeo/api/v2/constructions/${params.id}`)
    const construction = await response.json()
    return {
        props: {construction}, // will be passed to the page component as props
    }
}