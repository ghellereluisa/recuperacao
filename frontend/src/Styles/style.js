import styled from "styled-components";

export const Container = styled.div`
  width: 100vw;
  height: 100vh;
  padding: 40px 10%;
  background: #84ecac;
`;

export const TableHeader = styled.div`
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 20px;
    background-color: rgba(153, 214, 163, 0.993);
    margin-top: 50px;
    border-bottom: none;
    button {
        padding: 15px 20px;
        background: #f00602;
        color: rgb(0, 0, 0);
        border: none;
        border-radius: 10px;
        font-weight: 600;
        cursor: pointer;
    }
`;