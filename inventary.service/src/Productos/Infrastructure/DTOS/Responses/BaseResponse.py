class BaseResponse:
    def __init__(self, data , message, status , httpsstatuscode):
        self.data = data
        self.message = message
        self.status =  status
        self.httpstatuscode = httpsstatuscode
        
    def response(self):
        return{
            "data" : self.data,
            "message" : self.message,
            "status" : self.status,
            "httpstatuscode" : self.httpsstatuscode
        }