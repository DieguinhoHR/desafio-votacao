import styled from "styled-components";

export const Container = styled.div`
  margin-top: 4rem;

  button {
        font-size: 1rem;
        color: #FFFFFF;
        background: var(--blue-light);
        border: 0;
        padding: 0 2rem;
        border-radius: 0.25rem;
        height: 2rem;
        margin: 1px;

        transition: filter 0.2s ease;

    &:hover{
      filter: brightness(0.9);
    }
  }

  table {
    width: 100%;
    border-spacing: 0 0.5rem;

    th {
      color: var(--text);
      font-weight: 400;
      padding: 1rem 2rem;
      text-align: left;
      line-height: 1.5rem;
    }

    td {
      padding: 1rem 2rem;
      border: 0;
      background: var(--white);
      color: var(--text);
      border-radius: 0.25rem;

      &:first-child {
        color: var(--title);
      }

      &.sim {
        color: var(--green);
      }

      &.nao {
        color: var(--red);
      }

    }
  }

`