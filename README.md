# Camunda Hands-on Workshop

This repo contains files and starter code needed to follow along to an in-house workshop about [Camunda](https://camunda.com/). The code in this repo is by no mean representative of a secure/functional application. It is however useful to gather basic insights in the workings of Camunda using a Remote Engine configuration. The provided documentation is written in Dutch.  
  
The entirety of this workshop was made by students of the [HAN University of Applied Sciences](https://hanuniversity.com/en/) for an assignment by [JDI Smart Web Application](https://www.jdi.nl/en).

## Getting started

In order to get started with the code in this repository clone it through your prefered method/git-client.
The repository contains Docker build-files to set up and run an initial version of a Remote Engine and a basic Worker Node that will connect to this Engine. There's also a base-version of a BPMN-workflow scheme inside of the engine that will need to be added in the course of the workshop.

## Workshop contents

- Modifying and updating BPMN-workflows.
- Brief explanation of Remote Engine using Spring Boot.
- Explanation of intersystem connectivity and possible security implementations.  
  *(For sake of time these are only mentioned/demonstrated in code since these take considerable set-up time for the environments)*
- Writing classes to connect to System Tasks on a Remote Engine in Spring Boot.

## Setup guide

Todo

## Provided documentation

In the folder `docs` there are two documents, consisting of a research-paper tackling some of the questionpoints that arose during our investigation into Camunda, as well a design description showing how we built up a layered architecture to work with a Remote Engine scenario.

## Contributors

| Name                | Webpage | Socials |
| ------------------- | ------- | ------- |
| Dennis Vlaanderen   |         |         |
| Sem Hones           |         |         |
| Thom Kraaijvanger   |         |         |
| Egbert-Jan Terpstra |         |         |
